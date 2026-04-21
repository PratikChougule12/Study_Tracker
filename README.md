# 📚 Study Tracker

A simple command-line Java application to help students log, track, and analyze their study sessions. Record what you studied, for how long, and generate summaries by date or subject — all from your terminal.

---

## ✨ Features

- **Log Study Sessions** — Record subject, duration (in hours), and a description for each session
- **View All Logs** — Display every study entry in a clean readable format
- **Export to CSV** — Save your study data to `StudyTracker.csv` for use in Excel or Google Sheets
- **Summary by Date** — See total hours studied for each day
- **Summary by Subject** — See total hours studied per subject

---

## 🖥️ Requirements

- Java JDK 8 or higher
- Command-line / terminal

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/study-tracker.git
cd study-tracker
```

### 2. Compile

```bash
javac program902.java
```

### 3. Run

```bash
java program902
```

---

## 📋 Menu Options

```
1 : Insert new Study Log
2 : View all Study Logs
3 : Export Study Log to CSV
4 : Summary of Study Log by Date
5 : Summary of Study Log by Subject
6 : Exit
```

---

## 📁 Project Structure

```
study-tracker/
│
├── program902.java        # Main source file (contains all classes)
└── README.md
```

### Classes Overview

| Class | Responsibility |
|-------|----------------|
| `StudyLog` | Model class — stores date, subject, duration, and description for one session |
| `StudyTracker` | Service class — manages the list of logs and all operations (insert, display, export, summarize) |
| `program902` | Entry point — runs the interactive menu loop |

---

## 📊 Sample Output

**Inserting a Log:**
```
---------------------------------------------------------------
-------------- Enter Valid Details of Your Study --------------
---------------------------------------------------------------
Please enter the name of Subject like C/C++/Java/Python
Java
Enter the time period of your study in hours
2.5
Please provide description of your study
Practiced OOP concepts and Collections
Study Log gets stored Successfully
```

**Viewing Logs:**
```
2025-01-15 | Java   | 2.5 | Practiced OOP concepts and Collections
2025-01-15 | Python | 1.5 | Worked on list comprehensions
```

**Summary by Subject:**
```
Subject : Java   Total study Duration : 5.5
Subject : Python Total study Duration : 3.0
```

**CSV Export (`StudyTracker.csv`):**
```
Date,Subject,Duration,Description
2025-01-15,Java,2.5,Practiced OOP concepts and Collections
2025-01-15,Python,1.5,Worked on list comprehensions
```

---

## ⚠️ Known Limitations

- Study logs are stored **in memory only** — data is lost when the program exits (no persistence between sessions)
- The date is automatically set to **today's date**; past dates cannot be entered manually

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you'd like to change.

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

---

## 👤 Author

Made with ❤️ by **[Your Name]**  
GitHub: [@your-username](https://github.com/your-username)
