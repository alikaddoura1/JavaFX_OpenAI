# Author: Ali Kaddoura

import sys
import keras_nlp
import keras
import tensorflow as tf
from transformers import AutoTokenizer, TFAutoModelForSeq2SeqLM, AutoModelForSeq2SeqLM, BlenderbotConfig, AutoModelForCausalLM
import transformers
from huggingface_hub import login
import os



login(token="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")  # Replace with your actual token

access_token  = "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"

os.environ["HF_TOKEN"] = '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'


# Load the tokenizer and model
model_name = "google/gemma-7b"  
tokenizer = AutoTokenizer.from_pretrained(model_name, token = access_token)
model = AutoModelForCausalLM.from_pretrained(model_name, token = access_token) 

# Tokenize input text
input_text = "The quick brown fox jumps over the lazy dog."
inputs = tokenizer(input_text, return_tensors="tf")

# Generate predictions
outputs = model.generate(inpu