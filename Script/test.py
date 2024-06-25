# Author: Ali Kaddoura

import sys
import keras_nlp
import keras
import tensorflow as tf
from keras import models

import os


import kagglehub
from kaggle.api.kaggle_api_extended import KaggleApi


os.environ['alikaddoura1'] = 'your_kaggle_username'
os.environ['d2079a394a618d91228854f2804b2070'] = 'your_kaggle_key'

api = KaggleApi()
api.authenticate()


path = kagglehub.model_download("keras/gemma/keras/gemma_1.1_instruct_2b_en")

print("Path to model files:", path)


# Download latest version
def generate_text():
    gemma_lm = keras_nlp.models.GemmaCausalLM.from_preset("gemma_2b_en")
    gemma_lm.generate("Keras is a", max_length=30)

    # Generate with batched prompts.
    gemma_lm.generate(["Keras is a", "I want to say"], max_length=30)

 
def main():
    # Read data from standard input
    data = sys.stdin.read()
    print("Data received:", data) 

if __name__ == "__main__":
    gen