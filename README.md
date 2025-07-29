# JDA Example Bot

This project is a simple and extendable example of a Discord bot built with the [JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA) library.

---

## 🚀 Getting Started

To run this bot on your machine, follow these steps:

1. **Clone the repository**

   ```bash
   git clone https://github.com/YourUsername/JDA-Example-Bot.git
   ```

2. **Fill in the `config.yml` file**

   * You must provide your bot token in the configuration file before starting the bot.
   * Example `config.yml`:

     ```yaml
     token: "YOUR_BOT_TOKEN_HERE"
     prefix: "!"
     ```

3. **Start the bot**

   * Use the provided `start.bat` file (for Windows):

     ```bat
     java -jar target/JDA-Example-Bot.jar
     ```
   * Or run via terminal (after building):

     ```bash
     mvn clean package
     java -jar target/JDA-Example-Bot.jar
     ```

---

## 🧩 Features

* ✅ Easy to customize command structure
* ⚙️ Configuration via `config.yml`
* 📦 Lightweight and modular
* 📚 Ideal for learning or for starting a new JDA-based project

---

## ❗ Notes

* This is a **basic** example intended for educational purposes.
* Do not share your bot token publicly.
