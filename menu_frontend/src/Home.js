import React from 'react';
import './Home.css';


function Home() {
    return (
        <div className="home">
            <nav className="navbar">
                <img src="/mcgill-transparent.png" alt="McGill Logo" className="logo" />
                <div className="nav-links">
                    <a href="/">Home</a>
                    <a href="/menu">View Food Locations</a>
                    <a href="/contact">Contact</a>
                    {/* Add more links here as needed */}
                </div>
            </nav>
            <header className="header">
                <h1>Welcome to McMenu!</h1>
            </header>
            {/* Add more content here */}
            <div className="button-container">
                <button className="button">View Food Locations</button>
                {/* Add another button here if needed */}
            </div>
        </div>
    );
}

export default Home;