package pi.arctic.ecopower.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HistoriqueAchat {
    private Long id;
    private LocalDateTime dateAchat;
    private Long userId;
}
