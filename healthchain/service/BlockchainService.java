////package msr.healthchain.service;
////
////import org.springframework.stereotype.Service;
////import org.web3j.crypto.Credentials;
////import org.web3j.protocol.Web3j;
////import org.web3j.protocol.http.HttpService;
////import org.web3j.tx.gas.DefaultGasProvider;
////import java.math.BigInteger;
////
////@Service
////public class BlockchainService {
////    private static final String CONTRACT_ADDRESS = "0xYourDeployedContractAddress";
////    private final HealthChainContractWrapper contract;
////
////    public BlockchainService() throws Exception {
////        Web3j web3j = Web3j.build(new HttpService("https://sepolia.infura.io/v3/YOUR_INFURA_KEY"));
////        Credentials credentials = Credentials.create("YOUR_PRIVATE_KEY");
////
////        this.contract = HealthChainContractWrapper.load(
////                CONTRACT_ADDRESS,
////                web3j,
////                new org.web3j.tx.RawTransactionManager(web3j, credentials, 1337L),
////                new DefaultGasProvider() {
////                    @Override public BigInteger getGasPrice() { return BigInteger.valueOf(20_000_000_000L); }
////                    @Override public BigInteger getGasLimit() { return BigInteger.valueOf(6_000_000L); }
////                }
////        );
////    }
////
////    public String storeRecord(String recordId, String ipfsHash) throws Exception {
////        return contract.storeRecord(recordId, ipfsHash);
////    }
////
////    public String grantAccess(String recordId, String doctorAddress) throws Exception {
////        return contract.grantAccess(recordId, doctorAddress);
////    }
////}
//
//// Example updated BlockchainService.java
//package msr.healthchain.service;
//
//import msr.healthchain.contracts.HealthChain;
//import org.springframework.stereotype.Service;
//import org.web3j.crypto.Credentials;
//import org.web3j.protocol.Web3j;
//import org.web3j.tx.gas.ContractGasProvider;
//import org.web3j.tx.gas.DefaultGasProvider;
//
//@Service
//public class BlockchainService {
//    private final Web3j web3j;
//    private final Credentials credentials;
//    private HealthChain healthChain;
//
//    public BlockchainService(Web3j web3j, Credentials credentials) {
//        this.web3j = web3j;
//        this.credentials = credentials;
//    }
//
//    public String deployContract() throws Exception {
//        ContractGasProvider gasProvider = new DefaultGasProvider();
//        healthChain = HealthChain.deploy(web3j, credentials, gasProvider).send();
//        return healthChain.getContractAddress();
//    }
//
//    public String storeRecord(String recordId, String ipfsHash) throws Exception {
//        return healthChain.storeRecord(recordId, ipfsHash)
//                .send()
//                .getTransactionHash();
//    }
//
//    public String getRecord(String recordId) throws Exception {
//        return healthChain.getRecord(recordId).send();
//    }
//}
package msr.healthchain.service;

import org.springframework.stereotype.Service;

@Service
public class BlockchainService {
    public int getCurrentBlock() {
        return 854392;
    }
    public int getTransactionCount() {
        return 2431;
    }
}
