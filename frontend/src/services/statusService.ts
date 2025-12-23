/* Retrieves status of the backend server. */

export async function fetchStatus() {
    const response = await fetch('http://localhost:8080/status');

    if (!response.ok) {
        throw new Error(response.statusText);
    }

    const data = await response.text();

    console.log(data);
    return data;
  }
