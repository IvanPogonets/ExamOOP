package com.exam.app;

import java.util.Date;

public interface Service {
    public void AddClient();

    public void EditClient();

    public void RemoveClient(long id, Date date);

    public void ViewClients();

    public void SearchIndustry();
}
