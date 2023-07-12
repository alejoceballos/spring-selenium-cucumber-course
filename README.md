# Spring, Selenium and Cucumber

My follow-up on the course I'm in right now.

- Course: https://www.udemy.com/course/cucumber-with-spring-boot/

## Browsers and Drivers Installations

First of all, I'm using WSL2 (Windows Subsystem for Linux) with Ubuntu 22 LTS. The solutions below may differ from
different versions and distributions.

To check your Debian Linux distribution and version, use: 
```shell
lsb_release -a
```

Something similar may be displayed:

```
No LSB modules are available.
Distributor ID: Ubuntu
Description:    Ubuntu 22.04.2 LTS
Release:        22.04
Codename:       jammy
```

### Install Google Chrome in Ubuntu on Windows Subsystem Linux

Reference:
- https://scottspence.com/posts/use-chrome-in-ubuntu-wsl

#### 1. Dependencies, make sure you’re up-to-date first:

```shell
sudo apt update && sudo apt -y upgrade && sudo apt -y autoremove
```

#### 2. Download and install Chrome:

```shell
wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
sudo apt -y install ./google-chrome-stable_current_amd64.deb
```

#### 3. Check that it’s installed ok:

```shell
google-chrome --version
```

Example output:

```
Google Chrome 114.0.5735.133
```

#### (OPTIONAL) Install ChromeDriver in Ubuntu on Windows Subsystem Linux

⚠️ **Attention!** _The steps below are just in case a third-party WebDriver configurer library cannot be used. There is
no need to install a Chrome Driver if this whole job can be delegated._

1. Go to https://chromedriver.chromium.org/downloads
2. Find the installed Google Chrome version from the list
3. ⚠️ Don't perform the steps below if you're going to use the third-party library
4. Click in the link of your Chrome version
5. Click on `chromedriver_linux64.zip` to download it
6. Unzip it

### Install Firefox in Ubuntu on Windows Subsystem Linux

Reference:
- https://askubuntu.com/questions/1444962/how-do-i-install-firefox-in-wsl-when-it-requires-snap-but-snap-doesnt-work

#### 1. Remove any reference to firefox:

```shell
sudo snap remove firefox
sudo apt remove firefox
```

**NOTE:** The `snap` removal may raise some error message like the one below:

```
error: cannot communicate with server: Post "http://localhost/v2/snaps/firefox": dial unix /run/snapd.socket: connect: no such file or directory
```

Don't worry, it just means that your WSL2 distro has nothing to uninstall through snap.

#### 2. Add Mozilla APP repository:

```shell
sudo add-apt-repository ppa:mozillateam/ppa
```

#### 3. Set the Mozilla APP preferences for firefox:

I don't really know why this is necessary. Just that it works. Create `/etc/apt/preferences.d/mozillateamppa` file and
fill it with the text below:

```
Package: firefox*
Pin: release o=LP-PPA-mozillateam
Pin-Priority: 501
```

**NOTE:** I use `nano` editor to create and edit files. For example:

```shell
sudo nano /etc/apt/preferences.d/mozillateamppa
```

#### 4. Install Firefox:

```shell
sudo apt update
sudo apt install firefox
```

#### 5. Check that it’s installed ok:

```shell
firefox -version
```

Example output:

```
Mozilla Firefox 115.0.2
```

#### (OPTIONAL) Install Gecko Driver in Ubuntu on Windows Subsystem Linux

Haven't done it. But you can start looking for it here:

- https://github.com/mozilla/geckodriver/

## Project and Dependencies

### Create a project with Spring Initializer

TBD - Link to https://start.spring.io/ and project configuration and initial dependencies

### Selenium and related dependencies

Add to `pom.xml`:

```xml
    .
    .
    .
    <dependencies>
        .
        .
        .
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.10.0</version>
        </dependency>

        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>${webdrivermanager.version}</version>
        </dependency>
        .
        .
        .
    </dependencies>
    .
    .
    .
```

### About WebDriver Manager

- Reference: https://bonigarcia.dev/webdrivermanager/

### WebDriver Configuration

#### 1. Create a config package and Spring Configuration called WebDriverConfig class as shown below:

```
.
└── com
    └── momo2x
        └── course
            └── springselcumber
                ├── SpringSeleniumCucumberCourseApplication.java
                └── config
                    └── WebDriverConfig.java
```

#### 2. Create a WebDriver Bean Factory method

- Create a WebDriver bean
- Create a WebDriverWait bean;

### Page Objects

- Reference: https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/

#### Create the Pages

- Create an abstract Base Page with EbDriver and WebDriverWait since it will be needed across other pages
- Create a concrete Page