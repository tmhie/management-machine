package com.example.machineservice.model;

import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MachineProductMapDTO {
    private Long id;
    private Integer capacity;
    private Integer remain;
    private String hexCode;
    private String slotCode;
    private Integer slotNo;
    private Double price;
    private ProductDTO product;
    private Boolean active;

    public String getSlotCode(){
        if (slotNo == null){
            return "DEAD";
        }
        return new StringBuilder()
                .append((char) (Math.ceil((double)slotNo / 10) + 64))
                .append((char) ((slotNo % 10 == 0) ? 74 : (slotNo % 10 + 64)))
                .toString();
    }

    public String getHexCode() {
        if(this.slotNo == null) {
            return "";
        }
        return new StringBuilder().append("00FF")
                .append((this.slotNo <= 16) ? "0" : "")
                .append(Integer.toHexString(this.slotNo).toUpperCase())
                .append(Integer.toHexString(255 - this.slotNo).toUpperCase())
                .append("AA55")
                .toString();
    }
}
