package com.example.warehouseapp.bot;

import com.example.warehouseapp.entity.BotUser;
import com.example.warehouseapp.entity.Warehouse;
import com.example.warehouseapp.repository.BotUserRepository;
import com.example.warehouseapp.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelegramServiceImpl implements TelegramService {

    @Autowired
    BotUserRepository botUserRepository;

    @Autowired
    WarehouseRepository warehouseRepository;

    @Override
    public SendMessage welcome(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(Constant.WELCOME_TEXT);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();

        KeyboardButton uzbek = new KeyboardButton(Constant.BUTTON_UZ);
        KeyboardButton rus = new KeyboardButton(Constant.BUTTON_RU);

        row1.add(uzbek);
        row2.add(rus);
        keyboardRowList.add(row1);
        keyboardRowList.add(row2);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }

    @Override
    public SendMessage shareContact(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();

        if (update.getMessage().getText().equals(Constant.BUTTON_UZ)) {
            KeyboardButton uzbek = new KeyboardButton(Constant.SHARE_CONTACT_UZ);
            uzbek.setRequestContact(true);
            row1.add(uzbek);
            sendMessage.setText(Constant.SHARE_CONTACT_UZ);
        } else {
            KeyboardButton rus = new KeyboardButton(Constant.SHARE_CONTACT_RU);
            rus.setRequestContact(true);
            row1.add(rus);
            sendMessage.setText(Constant.SHARE_CONTACT_RU);
        }
        keyboardRowList.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);


        return sendMessage;

    }

    @Override
    public SendMessage shareLocation(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();

        if (update.getMessage().getText().equals(Constant.SHARE_CONTACT_UZ)) {
            KeyboardButton uzbek = new KeyboardButton(Constant.SHARE_LOCATION_UZ);
            uzbek.setRequestLocation(true);
            row1.add(uzbek);
            sendMessage.setText(Constant.SHARE_LOCATION_UZ);
        } else {
            KeyboardButton rus = new KeyboardButton(Constant.SHARE_LOCATION_RU);
            rus.setRequestLocation(true);
            row1.add(rus);
            sendMessage.setText(Constant.SHARE_LOCATION_RU);
        }

        keyboardRowList.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }

    @Override
    public SendMessage mainMenu(Update update) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow row1 = new KeyboardRow();
        KeyboardRow row2 = new KeyboardRow();
        KeyboardRow row3 = new KeyboardRow();

        if (update.getMessage().getText().equals(Constant.SHARE_LOCATION_UZ)) {
            KeyboardButton uzbek = new KeyboardButton(Constant.WAREHOUSE_TEXT_UZ);
            KeyboardButton settings = new KeyboardButton(Constant.SETTING_TEXT_UZ);
            KeyboardButton help = new KeyboardButton(Constant.HELP_TEXT_UZ);
            uzbek.setRequestLocation(true);
            row1.add(uzbek);
            row2.add(settings);
            row3.add(help);
            sendMessage.setText(Constant.WAREHOUSE_TEXT_UZ);
        } else {
            KeyboardButton rus = new KeyboardButton(Constant.WAREHOUSE_TEXT_RU);
            KeyboardButton settings = new KeyboardButton(Constant.SETTING_TEXT_RU);
            KeyboardButton help = new KeyboardButton(Constant.HELP_TEXT_RU);
            rus.setRequestLocation(true);
            row1.add(rus);
            row2.add(settings);
            row3.add(help);
            sendMessage.setText(Constant.WAREHOUSE_TEXT_RU);
        }

        keyboardRowList.add(row1);
        keyboardRowList.add(row2);
        keyboardRowList.add(row3);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        return sendMessage;
    }

    @Override
    public SendMessage selectWarehouse(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        KeyboardRow row = null;
        KeyboardRow row1 = new KeyboardRow();

        List<Warehouse> warehouses = warehouseRepository.findAll();
        for (Warehouse warehouse : warehouses) {
            row = new KeyboardRow();
            KeyboardButton keyboardButton = new KeyboardButton();
            keyboardButton.setText(warehouse.getName());
            row.add(keyboardButton);
        }
        KeyboardButton back = new KeyboardButton();
//        back = update.getMessage().getText().equals(Constant.MENU_TEXT_UZ) ? back.setText(Constant.BACK_UZ) : back.setText(Constant.BACK_RU);
        row1.add(back);
        keyboardRowList.add(row);
        keyboardRowList.add(row1);
        replyKeyboardMarkup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        if (update.getMessage().getText().equals(Constant.MENU_TEXT_UZ)) {
            sendMessage.setText(Constant.WAREHOUSE_TEXT_UZ);
        } else {
            sendMessage.setText(Constant.WAREHOUSE_TEXT_RU);
        }
        return sendMessage;
    }

    @Override
    public SendMessage settings(Update update) {
        return null;
    }

    @Override
    public SendMessage help(Update update) {
        return null;
    }

    @Override
    public SendMessage menuProducts(Update update) {
        return null;
    }
}
