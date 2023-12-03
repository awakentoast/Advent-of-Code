#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_LINE_LENGTH 255
#define MAX_AMOUNT_OF_LINES 4

char* readFile(char* path) {
    FILE *file = fopen(path, "r");
    
    if (file == NULL) {
        printf("Could not read file %s", path);
        return NULL;
    }

   

    char (*inputs) = malloc(MAX_AMOUNT_OF_LINES * MAX_LINE_LENGTH);

    if (!inputs) {
        perror("Memory allocation error");
    }

    char line[MAX_LINE_LENGTH];

    int index = 0;
    while (fgets(line, MAX_LINE_LENGTH, file)) {
        strcpy(inputs[index++], line);
    }

    fclose(file);

    return inputs;
}


int main() {
    char (*inputs)[MAX_LINE_LENGTH] = readFile("test.txt");
    for (int i = 0; i < MAX_AMOUNT_OF_LINES; ++i)
    {
        printf("%s\n", inputs[i]);
    }
    free(inputs);
    return 0;
}