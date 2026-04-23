# BuBot Smart Voice Assistant

## Architecture

### Core Classes
- **`Application` & `Main`**: the main entry points for initializing the voice assistant
- **`VoiceRecognition`**: handles offline speech recognition using Sphinx4
- **`Controlling`**: the core controller managing voice commands and executing system actions
- **`Wiki`**: interfaces with the Wikipedia API to answer questions
- **`MailSendService`**: handles sending email notifications (e.g., for parent control)
- **`FileIng` & `SecurityAES`**: manage local, AES-encrypted file storage for settings and state
- **`MainConfig`**: stores configuration constants and keys

## Development

### Project Structure
```
src/main/java/main/artfix/
├── Application.java              # Bootstraps the application and checks initial setup
├── Main.java                     # Main launcher
├── MainConfig.java               # Global configuration and credentials
├── other/                        # Auxiliary features
│   ├── AdminMailChange.java      # Logic for changing the admin (parent) email
│   ├── OpenBrowser.java          # Utility to open web pages
│   ├── ResetAllSettings.java     # Resets all local data
│   ├── UserChange.java           # Handles user profiles (Child/Adult)
│   ├── Wiki.java                 # Wikipedia API integration
│   └── WikiSearchAccess.java     # Permission checks for Wiki search
├── system/                       # Core system utilities
│   ├── Controlling.java          # Processes recognized commands
│   ├── FileIng.java              # File reading/writing wrapper
│   ├── MailSendService.java      # SMTP email sending service
│   └── SecurityAES.java          # AES encryption for saved data
└── voiceControlling/             # Speech recognition logic
    ├── VoiceRecognition.java     # Sphinx4 offline recognition
    ├── VoiceRecognitionGlobal.java # Global listening loop
    └── VoiceSync.java            # Voice synchronization
```

## 📄 License

This project is open source and available under the [MIT License](LICENSE).


## 👨‍💻 Author

**Arthur Stepanyan**
- GitHub: [ArthurStep](https://github.com/ArthurStep)
- Version: 2.0

*Built with ☕ and lots of strategic thinking!*
