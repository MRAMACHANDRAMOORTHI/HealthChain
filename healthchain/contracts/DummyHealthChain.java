package msr.healthchain.contracts;

import org.web3j.abi.datatypes.Function;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.TransactionManager;
import java.util.Collections;
import java.util.concurrent.Callable;
import org.web3j.crypto.Credentials;
public class DummyHealthChain extends HealthChain {

    public DummyHealthChain() {
        super("0x0000000000000000000000000000000000000000", null,
                Credentials.create("0x0000000000000000000000000000000000000000000000000000000000000001"),
                (ContractGasProvider) null);
    }

    @Override
    public RemoteFunctionCall<String> getRecord(String recordId) {
        // Create a dummy function (with no inputs/outputs) to satisfy the constructor
        Function dummyFunction = new Function("getRecord", Collections.emptyList(), Collections.emptyList());
        return new RemoteFunctionCall<>(dummyFunction, new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "dummy-ipfs-hash";
            }
        });
    }

    @Override
    public RemoteFunctionCall<TransactionReceipt> storeRecord(String recordId, String ipfsHash) {
        Function dummyFunction = new Function("storeRecord", Collections.emptyList(), Collections.emptyList());
        return new RemoteFunctionCall<>(dummyFunction, new Callable<TransactionReceipt>() {
            @Override
            public TransactionReceipt call() throws Exception {
                TransactionReceipt receipt = new TransactionReceipt();
                receipt.setTransactionHash("dummy-tx-hash");
                return receipt;
            }
        });
    }
}
