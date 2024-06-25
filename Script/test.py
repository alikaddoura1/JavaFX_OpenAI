# Author: Ali Kaddoura

import sys
import keras_nlp
import tensorflow as tf
from keras import models

import os


import kagglehub

kagglehub.login()

# Download latest version
path = kagglehub.model_download("google/gemma/tfLite/gemma-2b-it-gpu-int4")

print("Path to model files:", path)
# Download latest version
def generate_text(paths):
    # Load Gemma model (example assumes it's a Keras model)
    path = paths
    gemma_model = tf.keras.models.load_model(path)

    # Use the model for inference
    # Example:
    input_text = "This is "
    max_length = 30
    result = gemma_model.predict([input_text], max_length=max_length)
    print("Generated Text:", result)

""" 
def main():
    # Read data from standard input
    data = sys.stdin.read()
    print("Data received:", data)  """

if __name__ == "__main__":
    generate_text(path)
 