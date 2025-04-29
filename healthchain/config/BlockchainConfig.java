package msr.healthchain.config;

import msr.healthchain.contracts.HealthChain;
import msr.healthchain.contracts.DummyHealthChain;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

@Configuration
public class BlockchainConfig {

    @Value("${blockchain.network.url:}")
    private String networkUrl;

    @Value("${wallet.private-key:}")
    private String privateKey;

    @Value("${contract.address:}")
    private String contractAddress;

    @Bean
    public Web3j web3j() {
        return (networkUrl != null && !networkUrl.isEmpty())
                ? Web3j.build(new HttpService(networkUrl))
                : null;
    }

    @Bean
    public Credentials credentials() {
        return (privateKey != null && !privateKey.isEmpty())
                ? Credentials.create(privateKey)
                : null;
    }

    @Bean
    public ContractGasProvider contractGasProvider() {
        return new DefaultGasProvider();
    }

    @Bean
    @ConditionalOnProperty(name = "blockchain.enabled", havingValue = "true")
    public HealthChain healthChain(Web3j web3j, Credentials credentials, ContractGasProvider gasProvider) throws Exception {
        return HealthChain.load(contractAddress, web3j, credentials, gasProvider);
    }

    @Bean
    @ConditionalOnProperty(name = "blockchain.enabled", havingValue = "false", matchIfMissing = true)
    public HealthChain dummyHealthChain() {
        return new DummyHealthChain();
    }
}
