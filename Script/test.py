# Author: Ali Kaddoura

import sys
import keras_nlp
import keras
from transformers import AutoTokenizer, TFAutoModelForSeq2SeqLM, AutoModelForSeq2SeqLM, BlenderbotConfig, AutoModelForCausalLM
from huggingface_hub import login
import os

login(token="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") 

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
outputs = model.generate(inputs["input_ids"], max_length=50)
generated_text = tokenizer.decode(outputs[0], skip_special_tokens=True)

print(generated_text)

def main():
    # Read data from standard input
    data = sys.stdin.read()
    print("Data received:", data) 


 