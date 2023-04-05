package Bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.json.JSONObject;
import java.net.URL;
import java.util.Scanner;

public class ExchangeRateBott extends TelegramLongPollingBot {
    private static final String API_KEY = "c01daf3f26245f3c31338106";

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if ("/exchange".equals(messageText)) {
                try {
                    double rate = getExchangeRate();
                    SendMessage message = new SendMessage()
                            .setChatId(chatId)
                            .setText(String.format("The current exchange rate is %.2f USD/EUR", rate));
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
            Scanner scanner = new Scanner(url.openStream(), "UTF-8").useDelimiter("\\A");
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
}
