### Sales Data Analyzer  
A program that analyzes .csv files and determines total revenue, average revenue, the top 5-best-sellers, sort by high volume, high value, as well as filtering by category.   

***
This is built as a beginner Java project to practice functional programming including high order functions, functional interfaces and composition, and stream API.  
*** 
Example of a .csv file the program reads:  

Laptop,Technology,3,999.99,2026-01-15  
Chair,Furniture,10,249.99,2026-01-18  
Notebook,OfficeSupplies,50,4.99,2026-01-20  
Desk,Furniture,5,399.99,2026-02-01  
Monitor,Technology,7,499.99,2026-02-10  
   

Product and category must have the first letter capitalized, and each segment must be separated with a comma with no spaces.  

*It is important to note that the only categories of products this program handles is "Technology", "Furniture", and "OfficeSupplies."  
***
Example of a generated report based on the example above:  

===== Sales Analysis Report =====  
Generated: 2026-05-30

Total Revenue: \$8249.28
Average Order Value: $2062.32

Revenue by Category:  
Technology: \$3499.93
Furniture: \$4499.85  
OfficeSupplies: $249.50
  

Top 5 Best Selling Products by Revenue:
1. Monitor - $3499.93
2. Chair - $2499.90
3. Desk - $1999.95
4. Notebook - $249.50  

Revenue from sales above \$100: \$7999.78  
Revenue from high volume sales (quantity > 10): $249.50
***
Prerequisites:  
JDK 21 or higher  
***
1. Clone the repository:  
git clone https://github.com/Sarthi267/Sales-Data-Analyzer.git  
2. Move into project directory:  
cd Sales-Data-Analyzer
3. Create a folder titled "Input" (capitalize the "I", output and processed folders will be created automatically after running)
4. Drop any .csv files you want into the input/folder (they must be titled "sales.csv")
5. Compile:  
javac -cp . src/com/salesanalyzer/*.java -d out
6. Run:  
java -cp out com.salesanalyzer.Main
7. Find your results:  
* Report generated in output/ with a timestamp 
* Processed files moved from Input into processed/[timestamp]/
***
### Notes
* Each run generates a new timestamped report
* Input folder clears automatically after every run
* Does not support multiple files processed concurrently, although implementing concurrency would fix that, this project focuses specifically on functional programming