# Dockerfile
FROM mcr.microsoft.com/playwright:v1.34.0-jammy

# Install Playwright
RUN mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install --with-deps"

# Set the working directory
WORKDIR /workspace