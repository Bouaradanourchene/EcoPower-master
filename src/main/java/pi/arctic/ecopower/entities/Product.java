package pi.arctic.ecopower.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Long id;
     String name;
    String descriptions;
    Double price;
    int quantity;
    @ManyToOne
    ProductCategory productCategory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productimage")
    Set<MultiPictures> multiPictures;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productCommentaire")
    Set<Commentaire> commentaires;



}
