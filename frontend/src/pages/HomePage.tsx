import { useNavigate } from 'react-router-dom';

export default function HomePage() {
    const navigate = useNavigate();

    const handleCreateMode = () => {
        alert('Create Mode is not yet complete!');
    }

    const handleCrawlMode = () => {
        navigate('/command');
    }


    return (
        <div>
            <h1>Create n' Crawl <p style={{fontSize: 'small'}}>v0.0.0 (Seriously, this isn't even close to done.)</p></h1>
            <h4>Select a mode:</h4>
            <div>
                <button onClick={handleCreateMode}>Create Mode</button> &nbsp;
                <button onClick={handleCrawlMode}>Crawl Mode</button>
            </div>
        </div>
    )
}