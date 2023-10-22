package com.paras;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LightningEvent implements Serializable {
    private Long timestamp;
    private float voltage;
    private long latitude;
    private long longitude;    
}
