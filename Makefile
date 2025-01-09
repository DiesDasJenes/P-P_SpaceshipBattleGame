# Variables
GRADLE = ./gradlew
BUILD_DIR = build

# Default task
.DEFAULT_GOAL := help

# Help task
help:
	@echo "Available commands:"
	@echo "  make build    - Build the project"
	@echo "  make test     - Run tests"
	@echo "  make clean    - Clean build directories"
	@echo "  make run      - Run the application"
	@echo "  make coverage - Generate test coverage report"
	@echo "  make check    - Run all checks (build, test, coverage)"
	@echo "  make wrapper  - Generate Gradle wrapper"

# Ensure gradlew exists
$(GRADLE):
	gradle wrapper

# Build the project
build: $(GRADLE)
	$(GRADLE) build -x test

# Run tests
test: $(GRADLE)
	$(GRADLE) test

# Clean build directories
clean: $(GRADLE)
	$(GRADLE) clean
	rm -rf $(BUILD_DIR)

# Run the application
run: $(GRADLE)
	$(GRADLE) run

# Generate test coverage report
coverage: $(GRADLE)
	$(GRADLE) jacocoTestReport
	@echo "Coverage report generated in build/jacocoHtml/index.html"

# Run all checks
check: build test coverage

# Generate Gradle wrapper
wrapper:
	gradle wrapper

# Prevent make from confusing file names with task names
.PHONY: help build test clean run coverage check wrapper 