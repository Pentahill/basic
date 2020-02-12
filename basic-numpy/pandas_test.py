import re
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

import warnings
warnings.filterwarnings('ignore')

train_data = pd.read_csv('2_train.csv')
test_data = pd.read_csv('2_test.csv')

train_data.Embarked[train_data.Embarked.isnull()] = train_data.Embarked.dropna().mode().values