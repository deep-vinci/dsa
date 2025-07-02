#include <stdio.h>
#include <stdlib.h>

#define MAX 100

int stack[MAX];
int top = -1;

void push(int value)
{
    if (top == MAX - 1)
    {
        printf("Stack overflow! Cannot push %d.\n", value);
        return;
    }
    stack[++top] = value;
    printf("%d pushed to stack\n", value);
}

void pop()
{
    if (top == -1)
    {
        printf("Stack underflow! Cannot pop element.\n");
        return;
    }
    int popped = stack[top--];
    printf("%d popped from stack\n", popped);
}

void peek()
{
    if (top == -1)
    {
        printf("Stack is empty. Nothing to peek.\n");
        return;
    }
    printf("Top element is %d\n", stack[top]);
}

void isEmpty()
{
    if (top == -1)
        printf("Stack is empty.\n");
    else
        printf("Stack is not empty.\n");
}

void isFull()
{
    if (top == MAX - 1)
        printf("Stack is full.\n");
    else
        printf("Stack is not full.\n");
}

void display()
{
    if (top == -1)
    {
        printf("Stack is empty.\n");
        return;
    }
    for (int i = 0; i <= top; i++)
    {
        printf("%d ", stack[i]);
    }
    printf("\n");
}

int main()
{
    int choice, value;

    while (1)
    {
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            scanf("%d", &value);
            push(value);
            break;
        case 2:
            pop();
            break;
        case 3:
            peek();
            break;
        case 4:
            isEmpty();
            break;
        case 5:
            display();
            break;
        case 6:
            printf("Exiting...\n");
            exit(0);
        default:
            printf("Invalid operation.\n");
        }
    }

    return 0;
}
