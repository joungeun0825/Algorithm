def solution(array, commands):
    answer = []
    for command in commands:
        i,j,k = command
        print(i,j,k)
        answer.append(list(sorted(array[i-1:j]))[k-1])
    return answer
