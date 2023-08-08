package ua.pp.salnikov.pizzatesttask.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {

    ACTIVE("Active"),
    DONE("Done"),
    CANCELED("Canceled");

    public final String status;

}
