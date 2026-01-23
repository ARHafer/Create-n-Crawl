export async function fetchCommandResponse(command: string) {
    const response = await fetch(`http://localhost:8080/game/command`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({ command }),
    })

    if (!response.ok) {
        throw new Error(response.statusText);
    }

    type CommandResponse = { output: string };
    const data: CommandResponse = await response.json();
    return data;
}
