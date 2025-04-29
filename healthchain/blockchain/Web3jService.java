package msr.healthchain.blockchain;

import jakarta.annotation.PostConstruct;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class Web3jService {
    private Web3j web3j;

    @PostConstruct
    public void init() {
        String infuraUrl = "https://sepolia.infura.io/v3/YOUR_INFURA_PROJECT_ID";
        this.web3j = Web3j.build(new HttpService(infuraUrl));
    }

    public String getLatestBlock() {
        try {
            return "Latest Block: " + web3j.ethBlockNumber().send().getBlockNumber();
        } catch (IOException e) {
            return "Error fetching block: " + e.getMessage();
        }
    }
}
