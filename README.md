# Data Analytics Hub Java App

Welcome to the Data Analytics Hub Java App! This application provides a platform for users to engage in data analytics related to social media posts. Users can log in, register, and explore the main dashboard where they can create new social media posts, load existing posts, and perform searches.

## Table of Contents
- [Installation](#installation)
- [Features](#features)
  - [Login](#login)
  - [User Registration](#user-registration)
  - [Main Dashboard](#main-dashboard)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Installation

1. Clone the repository to your local machine.
   ```bash
   git clone https://github.com/JBurkett86/DataAnalyticsHub.git
   ```
2. Open the project in your preferred Java IDE (Integrated Development Environment).

3. Build and run the application.

## Features

### Login
The application opens with a secure login window. Users need to enter their username and password to access the Data Analytics Hub. Invalid login attempts will be appropriately handled, ensuring the security of user accounts.

### User Registration
New users can register by providing essential information such as a username, first name, last name, and password. The registration process ensures unique usernames and secure password storage.

### Main Dashboard
Upon successful login, users are directed to the main dashboard. Here, they can:

- **Add a Social Media Post:** Create and publish new social media posts, including content and relevant metadata.
  
- **Load a Post:** Access and load existing social media posts for analysis or further modification.
  
- **Search:** Perform searches based on various criteria, facilitating efficient data analytics.

## Usage

1. **Login:**
   - Launch the application and enter your username and password.
   - Click the login button to access the main dashboard.

2. **User Registration:**
   - If you are a new user, click on the registration link.
   - Complete the registration form with your details.
   - Click the register button to create your account.

3. **Main Dashboard:**
   - Explore the dashboard to create new posts, load existing ones, and perform searches.
   - Use the navigation features to switch between different functionalities.
     
4. **Add Post:**
   - From the Main Dashboard press Add Post.
   - A new Post requires a unique ID, comment date time posted, share and like count.
   - If the post type is a reply, a valid existing Main Post ID must be entered, otherwise leave as 0.
     
5. **Find Post:**
   - From the Main Dashboard press Find Post.
   - Posts can be searched by their unique post ID


## Contributing

Contributions are welcome! If you find a bug, have a suggestion, or want to contribute new features, please follow the [contribution guidelines](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE.md).
