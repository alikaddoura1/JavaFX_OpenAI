# Author: Ali Kaddoura

import openai
import sys

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

# Example usage
question = "What is the capital of France?"
answer = ask_question(question)
print(answer)

""" 
def main():
    # Read data from standard input
    data = sys.stdin.read()
    print("Data received:", data) 
 """

 