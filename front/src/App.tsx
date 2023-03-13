import { useState } from 'react'
import './App.css'

function App() {

  return (
      <div className="information-dashboard">
          <data-container>
            <h1 slot="title">Deaths</h1>
            <div slot="value">100</div>
          </data-container>
          <data-container>
              <h1 slot="title">Alive</h1>
              <div slot="value">10</div>
          </data-container>
          <data-container>
              <h1 slot="title">Lol</h1>
              <div slot="value">0</div>
          </data-container>
          <data-container>
              <h1 slot="title">i</h1>
              <div slot="value">100</div>
          </data-container>
          <data-container>
              <h1 slot="title">j</h1>
              <div slot="value">10</div>
          </data-container>
          <data-container>
              <h1 slot="title">k</h1>
              <div slot="value">0</div>
          </data-container>
          <data-container>
              <h1 slot="title">Deaths</h1>
              <div slot="value">100</div>
          </data-container>
          <data-container>
              <h1 slot="title">Alive</h1>
              <div slot="value">10</div>
          </data-container>
          <data-container>
              <h1 slot="title">Lol</h1>
              <div slot="value">0</div>
          </data-container>
      </div>
  )
}

export default App
