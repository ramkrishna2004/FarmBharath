# Load necessary libraries
library(ggplot2)

# Read data from CSV file
data <- read.csv("data.csv")

# Create a bar graph
ggplot(data, aes(x = CropName, y = Quantity, fill = CropName)) +
		geom_bar(stat = "identity") +
		labs(title = "Crop Quantity by Crop Name", x = "Crop Name", y = "Quantity") +
		theme_minimal()

# Save the graph as an image (PNG)
ggsave("/eAgri/src/main/webapp/Images/output.png", width = 8, height = 4)
