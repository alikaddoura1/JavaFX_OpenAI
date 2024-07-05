# Author: Ali Kaddoura

import openai
import sys
import keras_nlp
import keras
import tensorflow as tf
import transformers
from transformers import AutoTokenizer, TFAutoModelForSeq2SeqLM, AutoModelForSeq2SeqLM, BlenderbotConfig, AutoModelForCausalLM
from huggingface_hub import login
import os

# Replace 'your-api-key' with your actual API key
openai.api_key = 'sk-proj-wxaIharEy2H6qlCLPwv4T3BlbkFJRagYdUw6YqYm2t1Sk6Ah'

def ask_question(question):
    response = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=[
            {"role": "system", "content": "You are a helpful assistant."},
            {"role": "user", "content": question}
        ]
    )
    return response['choices'][0]['message']['content']


question = "What is the capital of France?"
answer = ask_question(question)



def main():
    # Read data from standard input
    data = sys.stdin.read()
    print("Data received:", data) 

    question = data
    answer = ask_question(question)
    print("Answer: " + answer)


 