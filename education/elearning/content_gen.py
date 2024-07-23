import openai

# openai.api_key = "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"
# openai.api_key = "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"
openai.api_key = "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"

history = []

while True:
    user_input = input("Your input: ")

    messages = []
    for input_text, completion_text in history:
        messages.append({"role": "user", "content": input_text})
        messages.append({"role": "assistant", "content": completion_text})

    messages.append({"role": "user", "content": user_input})

    completion = openai.ChatCompletion.create(
        model="gpt-3.5-turbo",
        messages=messages
    )

    completion_text = completion.choices[0].message.content
    print(completion_text)

    history.append((user_input, completion_text))

    # user_input = input("Would you like to continue the conversation? (Y/N) ")
    # if user_input.upper() == "N":
    #     break
    # elif user_input.upper() != "Y":
    #     print("Invalid input. Please enter 'Y' or 'N'.")
    #     break