package net.devaction.kafka.transferswebsocketsservice.transferscustomstore;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.devaction.entity.TransferEntity;

/**
 * @author Víctor Gil
 *
 * since October 2019
 */
public class TransfersStoreImpl {

    private static final Logger log = LoggerFactory.getLogger(TransfersStoreImpl.class);

    private Map<String, HashSet<TransferEntity>> accountTransfersMap = new HashMap<String, HashSet<TransferEntity>>();

    public void add(TransferEntity transfer) {
        if (accountTransfersMap.containsKey(transfer.getAccountId())) {
            accountTransfersMap.get(transfer.getAccountId()).add(transfer);
        } else {
            HashSet<TransferEntity> transfers = new HashSet<TransferEntity>();
            transfers.add(transfer);
            accountTransfersMap.put(transfer.getAccountId(), transfers);
        }
    }

    public Set<TransferEntity> getTransfers(String accountId) {
        if (accountTransfersMap.containsKey(accountId)) {
            return accountTransfersMap.get(accountId);
        }

        return new HashSet<TransferEntity>(0);
    }
}