package com.sirocu.sipoint.event;

import com.sirocu.sipoint.entity.UserEntity;
import com.sirocu.sipoint.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UserEvent {

    private UserEntity user;
    private EventType type;
    private Map<?,?> data;
}
