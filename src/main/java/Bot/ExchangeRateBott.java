package Bot;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.groupadministration.SetChatPhoto;
import org.telegram.telegrambots.meta.api.methods.send.*;
import org.telegram.telegrambots.meta.api.methods.stickers.AddStickerToSet;
import org.telegram.telegrambots.meta.api.methods.stickers.CreateNewStickerSet;
import org.telegram.telegrambots.meta.api.methods.stickers.SetStickerSetThumb;
import org.telegram.telegrambots.meta.api.methods.stickers.UploadStickerFile;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.json.JSONObject;

import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
@Component
public class ExchangeRateBott extends TelegramLongPollingBot {
    private static final String API_KEY = "c01daf3f26245f3c31338106";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String text = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            if ("/exchange".equals(text)) {
                try {
                    double rate = getExchangeRate();
                    String messageText = String.format("The current exchange rate is %.2f USD/EUR", rate);
                    SendMessage message = new SendMessage();
                            message.setChatId(String.valueOf(chatId));
                    message.setText(messageText);
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private double getExchangeRate() {
        try {
            URL url = new URL("https://api.exchangeratesapi.io/latest?base=USD&symbols=EUR");
            Scanner scanner = new Scanner(url.openStream(),"UTF-8").useDelimiter("\\A");
            String response = scanner.next();
            JSONObject json = new JSONObject(response);
            return json.getJSONObject("rates").getDouble("EUR");
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public String getBotUsername() {
        return "ExUSDMoneyBot";
    }

    @Override
    public String getBotToken() {
        return "5821487909:AAH4WwwWWco-guOZlRWXodfFelTI8mFNkDA";
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendDocument sendDocument) {
        return null;
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendPhoto sendPhoto) {
        return null;
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendVideo sendVideo) {
        return null;
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendVideoNote sendVideoNote) {
        return null;
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendSticker sendSticker) {
        return null;
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendAudio sendAudio) {
        return null;
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendVoice sendVoice) {
        return null;
    }

    @Override
    public CompletableFuture<List<Message>> executeAsync(SendMediaGroup sendMediaGroup) {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> executeAsync(SetChatPhoto setChatPhoto) {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> executeAsync(AddStickerToSet addStickerToSet) {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> executeAsync(SetStickerSetThumb setStickerSetThumb) {
        return null;
    }

    @Override
    public CompletableFuture<Boolean> executeAsync(CreateNewStickerSet createNewStickerSet) {
        return null;
    }

    @Override
    public CompletableFuture<File> executeAsync(UploadStickerFile uploadStickerFile) {
        return null;
    }

    @Override
    public CompletableFuture<Serializable> executeAsync(EditMessageMedia editMessageMedia) {
        return null;
    }

    @Override
    public CompletableFuture<Message> executeAsync(SendAnimation sendAnimation) {
        return null;
    }

    @Override
    protected <T extends Serializable, Method extends BotApiMethod<T>> CompletableFuture<T> sendApiMethodAsync(Method method) {
        return null;
    }
}
