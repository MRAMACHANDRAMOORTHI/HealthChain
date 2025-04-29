package msr.healthchain.controller;

import msr.healthchain.service.BlockchainService;
import msr.healthchain.service.SolanaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BlockchainController {
    private final BlockchainService blockchainService;
    private final SolanaService solanaService;

    public BlockchainController(BlockchainService blockchainService, SolanaService solanaService) {
        this.blockchainService = blockchainService;
        this.solanaService = solanaService;
    }

    @GetMapping("/api/blockchain")
    @ResponseBody
    public String getBlockchainInfo() {
        return "Current Block: " + blockchainService.getCurrentBlock() +
                ", TX Count: " + blockchainService.getTransactionCount() +
                ", Dummy Solana Hash: " + solanaService.getDummyBlockHash();
    }
}
