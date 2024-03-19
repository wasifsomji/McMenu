import React from "react";
import './Menu.css'

function Menu() {
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
                <h1>Food Locations on Campus:</h1>
            </header>
            {/* Add more content here */}
        </div>
    );
}

export default Menu;