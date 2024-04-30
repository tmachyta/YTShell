# YTShell

# Project Description:
🤌This project is a command-line interface for YouTube, 
allowing users to interact with various YouTube functions and data directly from the command line. 
It provides a convenient way to manage videos, channels, and other aspects of YouTube without leaving the console.

Key features of the project include searching for videos by year, getting max recent videos, getting report, 
finding video by first letter, finding video by likes, finding video by views🤌

## Setup

To set up the project, follow these steps:

### Prerequisites

Make sure you have the following software installed on your system:

- Java Development Kit (JDK) 17 or higher
- Spring Boot 3 or higher
- Apache Maven
- Apache Tomcat vesion 9 or higher

### Installation
- First of all, you should made your fork
- Second, clink on Code<> and clone link, after that open your Intellij Idea, click on Get from VCS
- past link, which you clone later

### Replace Placeholders:
To connect to your youtube, you should replace PlaceHolders in .application.properties
- Change YOUTUBE_CHANNEL_ID - to your youtube.channel-id
- Chnage YOUTUBE_KEY - to your youtube.key

# Commands 🤌:
- filter-by-views: List videos by views || command useful: filter-by-views --views views
- filter-by-year: List videos by year || command useful: filter-by-year --year year
- report: Run a report based on all of the videos of the current year
- filter-by-likes: List videos by likes || command useful: filter-by-likes --likes likes
- recent: List recent videos by max count || command useful: recent --max max
- filter-by-first-letter: List videos by first letter title || command useful: filter-by-first-letter --letter letter
