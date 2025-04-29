package msr.healthchain.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.9.8.
 */
@SuppressWarnings("rawtypes")
public class HealthChain extends Contract {
    public static final String BINARY = "6080604052348015600e575f80fd5b5061048e8061001c5f395ff3fe608060405234801561000f575f80fd5b5060043610610034575f3560e01c806311dd8845146100385780636386953f14610061575b5f80fd5b61004b61004636600461022f565b610076565b6040516100589190610269565b60405180910390f35b61007461006f36600461029e565b610124565b005b60605f826040516100879190610303565b90815260405190819003602001902080546100a190610319565b80601f01602080910402602001604051908101604052809291908181526020018280546100cd90610319565b80156101185780601f106100ef57610100808354040283529160200191610118565b820191905f5260205f20905b8154815290600101906020018083116100fb57829003601f168201915b50505050509050919050565b60408051808201825282815233602082015290515f90610145908590610303565b90815260405190819003602001902081518190610162908261039d565b5060209190910151600190910180546001600160a01b0319166001600160a01b039092169190911790555050565b634e487b7160e01b5f52604160045260245ffd5b5f82601f8301126101b3575f80fd5b813567ffffffffffffffff8111156101cd576101cd610190565b604051601f8201601f19908116603f0116810167ffffffffffffffff811182821017156101fc576101fc610190565b604052818152838201602001851015610213575f80fd5b816020850160208301375f918101602001919091529392505050565b5f6020828403121561023f575f80fd5b813567ffffffffffffffff811115610255575f80fd5b610261848285016101a4565b949350505050565b602081525f82518060208401528060208501604085015e5f604082850101526040601f19601f83011684010191505092915050565b5f80604083850312156102af575f80fd5b823567ffffffffffffffff8111156102c5575f80fd5b6102d1858286016101a4565b925050602083013567ffffffffffffffff8111156102ed575f80fd5b6102f9858286016101a4565b9150509250929050565b5f82518060208501845e5f920191825250919050565b600181811c9082168061032d57607f821691505b60208210810361034b57634e487b7160e01b5f52602260045260245ffd5b50919050565b601f82111561039857805f5260205f20601f840160051c810160208510156103765750805b601f840160051c820191505b81811015610395575f8155600101610382565b50505b505050565b815167ffffffffffffffff8111156103b7576103b7610190565b6103cb816103c58454610319565b84610351565b6020601f8211600181146103fd575f83156103e65750848201515b5f19600385901b1c1916600184901b178455610395565b5f84815260208120601f198516915b8281101561042c578785015182556020948501946001909201910161040c565b508482101561044957868401515f19600387901b60f8161c191681555b50505050600190811b0190555056fea264697066735822122011d6699f9ac12038c49a989bd5bf7d8568e35ce2d0c72e6a42d00aa54409882264736f6c634300081a0033";

    public static final String FUNC_GETRECORD = "getRecord";

    public static final String FUNC_STORERECORD = "storeRecord";

    @Deprecated
    protected HealthChain(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HealthChain(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected HealthChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected HealthChain(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<String> getRecord(String recordId) {
        final Function function = new Function(FUNC_GETRECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(recordId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> storeRecord(String recordId, String ipfsHash) {
        final Function function = new Function(
                FUNC_STORERECORD, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(recordId), 
                new org.web3j.abi.datatypes.Utf8String(ipfsHash)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static HealthChain load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HealthChain(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static HealthChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HealthChain(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static HealthChain load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new HealthChain(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static HealthChain load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new HealthChain(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<HealthChain> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(HealthChain.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<HealthChain> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HealthChain.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<HealthChain> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(HealthChain.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<HealthChain> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(HealthChain.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
