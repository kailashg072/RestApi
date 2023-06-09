package BikeRepair.Controller.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter

@Entity
@Table(name="files")
public class FileDB {


    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

    public FileDB() {}

    @OneToOne
    @JoinColumn(name="User_Dp")
    private UserData user;

    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }


}
