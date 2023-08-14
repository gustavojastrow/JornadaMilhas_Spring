package com.jast.jornada.chat;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class ChatGpt
{
    //Place your OpenAI API KEY here
    private static final String OPENAI_API_KEY = "your api key";

    public static String generateAIText(String prompt)
    {
        OpenAiService service = new OpenAiService(OPENAI_API_KEY);
        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt(prompt)
                .model("text-davinci-003")
                .maxTokens(1000)
                .build();

        return service.createCompletion(completionRequest).getChoices().get(0).getText().replace("\n", "");
    }
}