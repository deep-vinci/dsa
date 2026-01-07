#include <stdio.h>
#define SIZE 100

int queue[SIZE];
int front = -1, rear = -1;

void enqueue(int val)
{
    if (rear == SIZE - 1)
    {
        printf("Queue Overflow\n");
        return;
    }
    if (front == -1)
        front = 0;
    queue[++rear] = val;
}

int dequeue()
{
    if (front == -1 || front > rear)
    {
        printf("Queue Underflow\n");
        return -1;
    }
    return queue[front++];
}

void traverse()
{
    for (int i = front; i <= rear; i++)
        printf("%d ", queue[i]);
    printf("\n");
}

int search(int val)
{
    for (int i = front; i <= rear; i++)
        if (queue[i] == val)
            return i - front;
    return -1;
}

int main()
{
    enqueue(1);
    enqueue(2);
    enqueue(3);
    printf("Queue: ");
    traverse();
    printf("Dequeued: %d\n", dequeue());
    printf("Queue: ");
    traverse();
    printf("Search 3: Index %d\n", search(3));
    return 0;
}