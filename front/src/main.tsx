import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import { MantineProvider } from '@mantine/core';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <React.StrictMode>
        <BrowserRouter>
            <MantineProvider withGlobalStyles withNormalizeCSS>
                <HeaderComponent links={[
                    {"link": "/", "label": "Home"},
                    {"link": "/test", "label": "Test"}
                ]}/>

                <Routes>
                    <Route path="/" element={<App/>}/>
                </Routes>

                <FooterComponent/>
            </MantineProvider>
        </BrowserRouter>
    </React.StrictMode>,
)
