import java.time.LocalDateTime;
public class Crate {
    private StorageType storageType;
    private LocalDateTime creationDate;
    private String crateID;

    public Crate(StorageType storageType, String crateID){
        this.crateID = crateID;
        this.storageType = storageType;
        creationDate = LocalDateTime.now();
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getCrateID() {
        return crateID;
    }
}
