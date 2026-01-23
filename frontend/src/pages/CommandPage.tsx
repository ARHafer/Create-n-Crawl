import { useState } from 'react';
import { fetchCommandResponse } from '../services/commandService.ts';
import './CommandPage.css';

// Outputs are split into two parts: the repeated user input and the system output.
type Output = {
    type: 'input' | 'output';
    value: string;
};

export default function CommandInput() {
    const [command, setCommand] = useState<string>("");
    const [outputHistory, setOutputHistory] = useState<Output[]>([]);

    const handleSubmit = async (e: React.KeyboardEvent<HTMLInputElement>) => {
        if (e.key === 'Enter' && command.trim() !== "") {
            try {
                const response = await fetchCommandResponse(command);
                setOutputHistory(prevHistory => [
                    ...prevHistory,
                    { type: 'input', value: command },
                    { type: 'output', value: response.output }
                ]);
                setCommand("");
            } catch (error) {
                console.error("Error fetching command response: ", error);
                setOutputHistory(prevHistory => [
                    ...prevHistory,
                    { type: 'input', value: command },
                    { type: 'output', value: "There was an error processing your command. Check the console for details." }
                ]);
                setCommand("");
            }
        }
    }

    return (
    <div className="terminal">

        <div className="output">
            {outputHistory.map((text, i) => (
                <div key={i} className="output-text">
                    {text.type === 'input' && ( // If the text is an input, insert ">"
                        <span className="prompt">&gt;</span>
                    )}

                    {text.value}
                </div>
            ))}
        </div>

        <div className="input">
            <span className="prompt">&gt;</span>
            <input
                type="text"
                value={command}
                onChange={e => setCommand(e.target.value)}
                onKeyDown={handleSubmit}
            />
        </div>

    </div>
);

}
