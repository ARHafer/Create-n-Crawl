/* Displays the status of the backend server. */

import { useEffect, useState } from 'react';
import { fetchStatus } from '../services/statusService.ts';

export default function Status() {
  const [status, setStatus] = useState<string>("");
  const [failed, setFailed] = useState<boolean>(false);

    useEffect(() => {
        let isMounted = true;

        (async () => {
            try {
                const data = await fetchStatus();
                if (isMounted && data) {
                    setStatus(data);
                }
            } catch (error) {
                console.error(error);
                setFailed(true);
            }
        })();

        return () => { isMounted = false; };
    }, []);

    if (failed) {
        return (<div>Non-Operational</div>);
    } else {
        return (<div>{status || "Loading..."}</div>);
    }
}
