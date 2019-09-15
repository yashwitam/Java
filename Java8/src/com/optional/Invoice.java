package com.optional;

import java.util.stream.Stream;

public class Invoice {

    private String invoiceId;

    public Invoice(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }
}
