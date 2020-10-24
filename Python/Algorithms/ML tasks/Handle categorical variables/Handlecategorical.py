# Handling categorical Variables

#importing required libraries
import pandas as pd
from sklearn import preprocessing

# Reading csv file
df = pd.read_csv('data_restaurant.csv')
print(df.head())

# Extracting categorical features from above dataset
df1 = df[['Gender', 'Smoker', 'Day', 'Time']]

# Print first 5 records
print(df1.head())

# Using get_dummies method from pandas to handle categorical features
print(pd.get_dummies(df1).head())

print(df1.head())

# Using sklearn preprocessing to handle categorical features
le = preprocessing.LabelEncoder()
df2 = df1.apply(le.fit_transform)

print(df2.head())