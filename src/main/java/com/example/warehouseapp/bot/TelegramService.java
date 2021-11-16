package com.example.warehouseapp.bot;

import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface TelegramService {

    SendMessage welcome(Update update);


    SendMessage shareContact(Update update);

    SendMessage shareLocation(Update update);

    SendMessage mainMenu(Update update);

    SendMessage selectWarehouse(Update update);

    SendMessage settings(Update update);

    SendMessage help(Update update);

    SendMessage menuProducts(Update update);
}
